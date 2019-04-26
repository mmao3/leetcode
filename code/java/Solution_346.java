// queue based solution 
class MovingAverage {

    /** Initialize your data structure here. */
    private int sum;
    private Queue<Integer> window;
    int size;
    
    public MovingAverage(int size) {
        this.size = size;
        window = new LinkedList<>();
    }
    
    public double next(int val) {
        if(window.size() == size) {
            sum -= window.remove();
        }
        window.add(val);
        sum += val;
        return 1.0 * sum / window.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */


// Array based solution 
class MovingAverage {
    private int sum;
    private int[] window;
    int length;
    int index;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        length = 0;
        index = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (length < window.length) {
            length++;
        }
        sum -= window[index];
        window[index] = val;
        sum += val;
        index = ++index % window.length;
        return 1.0 * sum / length;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

