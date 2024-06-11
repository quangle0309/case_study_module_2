package common;

public class RegexHandler {
    private static final String USER_NAME_REGEX = "^[a-zA-Z0-9]{6,16}$";
    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9@]{6,16}$";
    private static final String NAME_REGEX = "^([A-ZĐÀÁẢÃẠĂẰẮẲẴẶÂẦẤẨẪẬÈÉẺẼẸÊỀẾỂỄỆÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢÙÚỦŨỤƯỪỨỬỮỰỲÝỶỸỴa-zđàáảãạăằắẳẵặâầấẩẫậèéẻẽẹêềếểễệìíỉĩịòóỏõọôồốổỗộơờớởỡợùúủũụưừứửữựỳýỷỹỵ]{0,30} *){1,10}$";
    private static final String PHONE_NUMBER_REGEX = "^[+]?\\d{10,11}$";
    private static final String STR_REGEX = "^[^!@#$%^&*()_`~-]{1,300}$";

    public static boolean isValidUsername(String username) {
        return username.matches(USER_NAME_REGEX);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean isValidName(String name) {
        return name.matches(NAME_REGEX);
    }

    public static boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

    public static boolean isNotValidString(String str) {
        return str.matches(STR_REGEX);
    }

}
