package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here
    @Column(nullable = false)
    private Long userId;

    //object type authority is granted on
    @Column(nullable = false)
    private String objectType;

    //id of object
    @Column(nullable = false)
    private Long objectId;

    //permission granted (read, update, delete, share, owner)
    @Column(nullable = false)
    private String permission;
    @PostUpdate
    @PostConstruct
    private void ObjectValid() {
        objectId = Long.valueOf(objectType + permission);
        System.out.println("object type is valid ");
    }

        @PreDestroy
        @PostConstruct
                public void Authentication(){
        permission = String.valueOf(userId + id);
            System.out.println("Permission was not granted");

        }


        
    }



