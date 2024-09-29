package pub.developers.forum.common.support;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author Qiangqiang.Bian
 * @create 2020/10/29
 * @desc
 **/
public class AvatarUtil {

    // https://www.gravatar.com/avatar/
    private static final String GRAVATAR_URL = "/uploads/avatar/%s";

    public static String get(String avatar, String email) {
        return ObjectUtils.isEmpty(avatar) ? String.format(GRAVATAR_URL, "head.png") : avatar;
    }

}
