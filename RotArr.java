/* https://www.interviewbit.com/problems/rotated-array/ */

public class RotArr {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
        int start = 0, end = a.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int midVal = a.get(mid);
            if ((mid == 0 && midVal <= a.get(end)) || midVal <= a.get(mid - 1)) {
                return midVal;
            } else if (midVal > a.get(start) && midVal > a.get(end)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return a.get(0);
    }
}