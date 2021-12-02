package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        List<Role> roles = (List<Role>) authentication.getAuthorities();

        boolean hasAdmin = roles.stream().anyMatch(r -> r.getRoleName().equals("ROLE_ADMIN"));

        if(hasAdmin) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/users");
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user");
        }
    }
}