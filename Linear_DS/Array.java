import java.util.*;

class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 
            *arrays are non-primitive category.
            *arrays stores collection of items with similar type
            *It access an individual element in O(1)
            *It stores in contingous memory
        */
        
        //declaration of an array:
        int[] arr;
        
        //intialization of an array:
        int[] array = {10,12,15,20};
        
        //Types of arrays 
        //Two types a)On basis of Size b)On basis of Dimension's
        
        //On basis of Size - fixed, or dynamic
        //On basis of Dimension's - 1d,2d, or jagged arrays
        
        //Fixed array: called it as Array Literal
        int[] nums = new int[5];
        //here we can store upto 5 elements not more than that.
        
        //Dynamic array:
        ArrayList<Integer> arr_ = new ArrayList<>();
        //here we can scale up or down the size.
        
        //1d dimension: single row where elements stored one after another
        int[] arrays = {10,12,15,20};
        
        //multi dimension: rows & cols i.e matrix we can store complex data in the form of tables. - 2d,3d.
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        
        int[][] newMatrix = new int[5][3];
        
        //jagged array: col size varies row wise 
        int[][] jaggedArray = new int[4][];
        jaggedArray[0] = new int[4];
        jaggedArray[1] = new int[1];
        jaggedArray[2] = new int[2];
        jaggedArray[3] = new int[3];

        
        //Main - workflow 
        
        int[] numList = new int[5];
        // System.out.println("Enter the array element's: ");
        for(int i=0;i<numList.length;i++){
            numList[i] = i;
        }
        
        //Traversal for 1d array - for loop
        for(int i=0;i<numList.length;i++){
            System.out.println(numList[i]);
        }  
        
        
        numList[2] = 100;
        
        // methods - (list) is name of the array
        // list.length
        // list[index] - access specfic element
        // list[index] = new_val 
        // Arrays.toString(arr_name)
        // Arrays.sort(arr_name)
        // Arrays.binarySearch(arr_name, target) - return index if target exists else return -1.
        // Arrays.copyOf(arr, specify end-index) - copy entire/partial array. return new array
        // Arrays.copyOfRange(arr, start_index,end_index) - inclusive
        // Arrays.equals(arr1,arr2) - T/F
        // Arrays.fill(arr_name, value)
        
        System.out.println(Arrays.toString(numList));
        int[] partialArr = Arrays.copyOf(numList, 2);
        System.out.println(Arrays.toString(partialArr));
        

        int[] sliceArr = Arrays.copyOfRange(numList, 2,4);
        System.out.println(Arrays.toString(sliceArr));

        System.out.println(Arrays.deepToString(matrix));
        
        int[] filled = new int[5];
        Arrays.fill(filled, 10);
        
        //2d dimension workflow 
        
        matrix[0][0] = 10;
        
        System.out.println("row size: "+matrix.length);
        System.out.println("col size: "+matrix[0].length);
        
        //traversal 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
        // Arrays.deepToString(matrix_name);
        // Arrays.deepEquals(matrix1,matrix2)
        
        // sort - 
        for(int i=0;i<matrix.length;i++){
            Arrays.sort(matrix[i]);
        }
        System.out.println(Arrays.deepToString(matrix));
        
        //Enhanced For Loop 
        
        //1d
        for(int i: numList){
            System.out.println(i);
        }
        
        //2d 
        for(int[] row: matrix){
            for(int col: row){
                System.out.println(col);
            }
            // System.out.println(Arrays.toString(row));
        }
        
        /*
            ArrayList: resizable(dynamic) array in java that can grow or shrink automatically.
            Hiearchy of ArrayList:
            ArrayList(class)
                implements
            List Interface
                extends 
            collection
        */
        
        //creation:
        ArrayList<Integer> arrList = new ArrayList<>();
        
        arrList.add(1);
        arrList.add(2);//adds at end
        arrList.add(0);
        arrList.add(-22);
        System.out.println(arrList);
        System.out.println(arrList.size());
        
        arrList.add(1,20); //adds at specfic index
        System.out.println(arrList);
        
        System.out.println(arrList.get(1)); // accessing element at index 1 
        
        arrList.set(1, 25); //updates the value at index pos
        System.out.println(arrList.get(1)); 

        arrList.remove(1); //removes the value at index pos 
        
        boolean isExists = arrList.contains(2);
        System.out.println(isExists);
        
        // arrList.clear();
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("azar");
        strArr.add("firoz");
        Iterator<String> it = strArr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        //Collection methods:
        
        Collections.sort(arrList); 
        
        System.out.println(arrList);
        
        Collections.sort(arrList, Collections.reverseOrder());
        
        System.out.println(arrList);
        
        String[] str = {"wow","hi"};
        
        //Conversion of Array -> ArrayList
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str));

        
        
        //Conversion of List -> Primitive array
        int[] primitiveArr = new int[arrList.size()];
        for(int i=0;i<arrList.size();i++){
            primitiveArr[i] = arrList.get(i);
        }
        System.out.println(Arrays.toString(primitiveArr));
        
        //Primitive -> List
        List<Integer> lists = new ArrayList<>();
        
        for (int value : primitiveArr) {
            lists.add(value);
        }
        System.out.println(lists);

        //How to Sort a 2d Matrix 
        //1. sort them indivually 
        for (int[] row : matrix) {
            Arrays.sort(row);
        }
        
        //2. flat the array and then sort whole array and fill them back.
        
        //3. custom sort using comparator
        Arrays.sort(matrix, (a,b) -> a[0] - b[0]);
        /*
            This returns:
            negative → a comes before b
            positive → a comes after b
            zero → equal ordering
            example a = [9,5] b=[3,10]
            so a-b = 9 - 3 => postive(6) so a comes after b
        */

    }
}