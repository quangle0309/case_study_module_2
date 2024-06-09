package model;

import java.io.Serializable;
import java.util.Objects;

public class BookOnLoan implements Serializable {
    private String usernameBorrow;
    private String nameBookBorrow;
    private String authorBookBorrow;

    public BookOnLoan() {
    }

    public BookOnLoan(String usernameBorrow, String nameBookBorrow, String authorBookBorrow) {
        this.usernameBorrow = usernameBorrow;
        this.nameBookBorrow = nameBookBorrow;
        this.authorBookBorrow = authorBookBorrow;
    }

    public String getUsernameBorrow() {
        return usernameBorrow;
    }

    public void setUsernameBorrow(String usernameBorrow) {
        this.usernameBorrow = usernameBorrow;
    }

    public String getNameBookBorrow() {
        return nameBookBorrow;
    }

    public void setNameBookBorrow(String nameBookBorrow) {
        this.nameBookBorrow = nameBookBorrow;
    }

    public String getAuthorBookBorrow() {
        return authorBookBorrow;
    }

    public void setAuthorBookBorrow(String authorBookBorrow) {
        this.authorBookBorrow = authorBookBorrow;
    }

    @Override
    public String toString() {
        return usernameBorrow + " đã mượn " + nameBookBorrow + " của tác giả " + authorBookBorrow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOnLoan bookOnLoan = (BookOnLoan) o;
        return Objects.equals(usernameBorrow, bookOnLoan.usernameBorrow) &&
                Objects.equals(nameBookBorrow, bookOnLoan.nameBookBorrow) &&
                Objects.equals(authorBookBorrow, bookOnLoan.authorBookBorrow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usernameBorrow, nameBookBorrow, authorBookBorrow);
    }
}

