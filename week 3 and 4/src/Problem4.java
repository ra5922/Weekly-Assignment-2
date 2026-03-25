
import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ":" + returnRate + "%";
    }
}

public class Problem4 {

    //  MERGE SORT (ASC by returnRate - STABLE)
    static void mergeSort(Asset[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] temp = new Asset[r - l + 1];

        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i].returnRate <= arr[j].returnRate) {
                temp[k++] = arr[i++]; // stable
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l; i <= r; i++) {
            arr[i] = temp[i - l];
        }
    }

    //  QUICK SORT (DESC by returnRate + volatility ASC)
    static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(Asset[] arr, int low, int high) {

        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (
                    arr[j].returnRate > pivot.returnRate || // DESC
                            (arr[j].returnRate == pivot.returnRate &&
                                    arr[j].volatility < pivot.volatility) // lower volatility first
            ) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Asset[] assets = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 7),
                new Asset("GOOG", 15, 4)
        };

        //  Merge Sort (ASC)
        mergeSort(assets, 0, assets.length - 1);
        System.out.println("Merge Sort (ASC): " + Arrays.toString(assets));

        //  Quick Sort (DESC)
        quickSort(assets, 0, assets.length - 1);
        System.out.println("Quick Sort (DESC): " + Arrays.toString(assets));
    }
}