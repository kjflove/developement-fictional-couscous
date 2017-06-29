package booking;

/**
 * Class description ...
 * Included in booking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Apr 2017
 */
public class Book implements IBook {
    private int ID;
    private String author;
    private String title;
    private String ISBN;
    private Publisher publisher;
    private int releaseYear;

    public Book(int ID, String author, String title, String ISBN, Publisher publisher, int releaseYear) {
        this.ID = ID;
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Book{ \n" +
                "    ID=" + ID + "\n" +
                "    , author='" + author + "\' \n" +
                "    , title='" + title + "\' \n" +
                "    , ISBN='" + ISBN + "\' \n" +
                "    , publisher=" + publisher + "\n" +
                "    , releaseYear=" + releaseYear + "\n" +
                '}';
    }

    @Override
    public <T> void correctInfo(BookAttribute attr, T info) {
        switch (attr) {
            case ID:
                if(info.getClass() == Integer.class)
                    this.setID((Integer) info);
                break;

            case AUTHOR:
                if(info.getClass() == String.class)
                    this.setAuthor((String) info);
                break;

            case TITLE:
                if(info.getClass() == String.class)
                    this.setTitle((String) info);
                break;

            case ISBN:
                if(info.getClass() == String.class)
                    this.setISBN((String) info);
                break;

            case PUBLISHER:
                if(info.getClass() == Publisher.class)
                    this.setPublisher((Publisher) info);
                break;

            case RELEASE_YEAR:
                if(info.getClass() == Integer.class)
                    this.setReleaseYear((Integer) info);
                break;
        }
    }

    @Override
    public String info() {
        return toString();
    }

    public boolean checkID(int id){
        return this.getID() == id;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
