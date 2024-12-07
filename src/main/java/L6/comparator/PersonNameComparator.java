package L6.comparator;

import L6.model.Place;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Place> {
    @Override
    public int compare(Place o1, Place o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }

}
