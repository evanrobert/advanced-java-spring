package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiTemplate {

        private String email;
        private String first_name;
        private String last_name;
    }

