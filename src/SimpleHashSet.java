import java.util.Iterator;
import java.util.NoSuchElementException;


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

    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString(){
        Entry currentEntry = null;
        StringBuffer sb = new StringBuffer();
        //loop through the array
        for (int index=0;index<buckets.length;index++){
            if(buckets[index] != null){
                currentEntry = buckets[index];
                sb.append("[" + index + "]");
                sb.append(" "+ currentEntry.key.toString());
                while (currentEntry.next != null){
                    currentEntry = currentEntry.next;
                    sb.append(" ->" + currentEntry.key.toString());
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public class SimpleHashSetIterator implements Iterator{

        private int currentBucket;
        private int previousBucket;
        private Entry currentEntry;
        private Entry previousEntry;

        public SimpleHashSetIterator(){
            currentEntry = null;
            previousEntry = null;
            currentBucket = -1;
            previousBucket = -1;
        }

        @Override
        public boolean hasNext(){
            //currentEntry node has next
            if(currentEntry != null && currentEntry.next != null){
                return true;
            }

            //there are still nodes
            for(int index = currentBucket+1; index <buckets.length; index++){
                if (buckets[index] != null) {
                    return true;
                }
            }

            //nothing left
            return false;
        }

        @Override
        public Object next(){
            previousEntry = currentEntry;
            previousBucket = currentBucket;

            // if either the current or next node are null
            if(currentEntry == null || currentEntry.next == null){
                //go to the next bucket
                currentBucket++;
                //keep going until you find a bucket with a node
                while(buckets[currentBucket] == null && currentBucket<buckets.length){
                    //go to the next bucket
                    currentBucket++;
                }
                if(currentBucket < buckets.length){
                    currentEntry =buckets[currentBucket];
                }
                //otherwise there are no more elements in the bucket
                else{
                    throw new NoSuchElementException();
                }
            }
            else{
                currentEntry = currentEntry.next;
            }
            //return the element in the current node
            return currentEntry.key;
        }

        public int size(){
            return size;
        }
    }

}
