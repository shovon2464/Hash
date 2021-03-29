
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
        
        if(currentEntry != null && currentEntry.next != null){
            return true;
        }
    }
}
