package br.com.sgsa.system.user.security.filter;

import br.com.sgsa.system.user.security.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Extrai o cabeçalho Authorization
        String authHeader = request.getHeader("Authorization");

        // Valida o formato do cabeçalho (deve começar com "Bearer ")
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Remove "Bearer " do início
            Claims claims = jwtUtil.extractClaims(token); // Extrai as claims do token

            // Configura o contexto de segurança se o token for válido
            if (claims != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                String email = claims.getSubject(); // Extrai o e-mail do token
                String role = claims.get("role", String.class); // Extrai o papel do token

                if (role != null && !role.isEmpty()) { // Verifica se o papel é válido
                    // Cria os detalhes do usuário
                    UserDetails userDetails = User.withUsername(email)
                            .password("") // Senha não é necessária
                            .authorities(new SimpleGrantedAuthority("ROLE_" + role)) // Prefixa ROLE_
                            .build();

                    // Cria o objeto de autenticação
                    var authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Configura o contexto de segurança
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }
        }

        // Continua a execução da cadeia de filtros
        chain.doFilter(request, response);
    }
}
