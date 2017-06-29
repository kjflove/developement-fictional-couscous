package booking;


import java.util.ArrayList;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Apr 2017
 */
public class Books<T extends IBook> extends ArrayList<T> {

    public Books() {
        super();
    }

    public void addBook(T book) throws IDNotAvailableException {
        if(!isIdReserved(book.getID())) {
            this.add(book);
        } else {
            throw new IDNotAvailableException(
                    "ID " + book.getID() + " is already taken. If you want to change it use correctBookData."
            );
        }
    }

    public String retriveBookInfo(int ID){
        T book = this.getByID(ID);
        return book != null
                ? book.toString()
                : "ID not available.";
    }

    public <Y> void correctBookData(int index, BookAttribute attr, Y info){
        this.get(index).correctInfo(attr, info);
    }

    public boolean isIdReserved(int id) {
        for (IBook b: this) {
            if(b.checkID(id)) return true;
        }
        return false;
    }

    public T getByID(int id) {
        for (T b: this) {
            if(b.checkID(id)) return b;
        }
        return null;
    }

    public int length() {
        return this.size();
    }

    public String listAllBooks(){
        StringBuilder sb = new StringBuilder("List of all registered book IDs: ");
        for (T book : this){
            sb.append("\n  " + book.getID()+ ", ");
        }

        if(this.size() <= 0) sb.append("\n   List is currently empty.");

        return sb.toString();
    }
}
