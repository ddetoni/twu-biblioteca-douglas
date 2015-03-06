package com.twu.biblioteca;

/**
 * Created by ddetoni on 2/26/15.
 */
public class Movie extends Item{
    private String rating;
    private String director;
    private String year;
    private String name;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;

    }

    @Override
    public String getDetailsSeparatedBy(String separator, boolean showAvaliability) {
        if(showAvaliability) {
            return name + separator + year + separator + director + separator + rating + separator + isAvailable() + separator + super.checkedOutBy().getIdentifier();
        } else {
            return name + separator + year + separator + director + separator + rating;
        }

    }
}
