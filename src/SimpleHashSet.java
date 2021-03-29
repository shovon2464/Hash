import java.util.Iterator;





public class SimpleHashSet implements SimpleSet {

    private static class Entry{
        Object key;
        Entry next;
    }

    private Entry [] buckets;

    private int size;

    public SimpleHashSet(int capacity){

        buckets = new Entry[capacity];
        size = 0;
    }

    private int hashFunction(int hashCode){
        int index = hashCode;
        if(index < 0){ index = -index;
        }
        return index % buckets.length;
    }

    @Override
    public boolean add(Object element) {
        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];

        while(current != null){
            //element is already in the set
            if(current.key.equals(element)){
                return false;
            }
            //otherwise visit next entry in the bucket
            current = current.next;
        }
        //no element found so add new entry
        Entry entry = new Entry();
        entry.key = element;
        //current entry is null if bucket is empty
        //if it is not null it becomes next Entry
        entry.next = buckets[index];
        buckets[index] = entry;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object element) {

        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];
        Entry previous = null;

        while(current != null){
            //element found so remove it
            if(current.key.equals(element)){

                if (previous == null){
                    buckets[index] = current.next;
                } else{
                    previous.next = current.next;
                }
                size --;
                return true;
            }
            previous = current;
            current = current.next;
        }
        //no element found nothing to remove
        return false;
    }

    @Override
    public boolean contains(Object element){
        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];

        while(current != null){
            //check if node contains element
            if(current.key.equals(element)){
                return true;
            }
            current = current.next;
        }
        //Element did not found
        return false;
    }
    @Override
    public Iterator iterator(){
        return new SimpleHashSetIterator();
    }


}
