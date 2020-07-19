package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.User;
import projektniZadatak.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
       return this.userRepository.save(user);
    }


    public User findByMail(String email){
        try {
            User user = this.userRepository.findFirstByEmail(email);
            String password = user.getPassword();
            return user;
        }catch(Exception e){
            System.out.println("greska");
        }
        User fail = new User();
        return fail;
    }


    public User findOne(Long id) {
        User user = this.userRepository.getOne(id);
        return user;
    }




}
