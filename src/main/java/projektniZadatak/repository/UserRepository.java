package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projektniZadatak.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
    //User findOneByEmail(String email);
    User findFirstByEmail(String email);

}
