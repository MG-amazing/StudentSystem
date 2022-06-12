package one.mapper;


import one.bean.Stuinfo;
import one.bean.User;

import java.util.List;

public interface MainInterfaceMapper {
    List<User> LoginVerification();
    List<Stuinfo>SelectStuInfo();
}
