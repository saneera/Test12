import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public static void swapEnd(int[] A, int i, int j) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }

    // Function to move all zeros present in the array to the end
    public static void partition(int[] A) {
        int j = 0;

        // each time we encounter a non-zero, `j` is incremented, and
        // the element is placed before the pivot
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0)        // pivot is 0
            {
                swapEnd(A, i, j);
                j++;
            }
        }
    }

    public static void swapBeginning(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
    }

    static void inTheBeginning(int[] array) {
        int startIndex = 0;
        int i, j;
        for (i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                for (j = i; j > startIndex; j--) {
                    swapBeginning(array, i, j);
                }
                startIndex++;
            }
        }
    }

    static IntStream revRange(int from, int to) {
        return IntStream.range(from, to).map(i -> to - i + from - 1);
    }

    public static void main(String[] args) {
        System.out.println("==========Swap Zero to End=================");
        int[] A = {6, 0, 8, 2, 3, 0, 4, 0, 1};
        System.out.println(Arrays.toString(A));
        partition(A);
        System.out.println(Arrays.toString(A));

        System.out.println("===========Swap Zero to Beginning================");
        int[] B = {6, 0, 8, 2, 3, 6, 4, 9, 1};
        System.out.println(Arrays.toString(B));
        inTheBeginning(B);
        System.out.println(Arrays.toString(B));


        System.out.println("==========Swap Zero to Beginning - Comparator=================");
        List<Integer> nums =Arrays.asList(6, 0, 8, 0, 3, 6, 0, 9, 1);
        System.out.println(nums);
        Collections.sort(nums, new CustomComparator());
        System.out.println(nums);

        System.out.println("==========FInd Max=================");

        int[] array = new int[] { 1, 2, 4, 1, 3, 4, 2, 2, 1, 5, 2, 3, 5 };

        Long max = Arrays.stream(array).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting())).values()
                .stream().max(Comparator.comparing(Function.identity())).orElse(0L);
        System.out.println(max);

        System.out.println("==========Second Largest Number=================");

        int[] numbers = {5, 9, 11, 2, 8, 21, 1};
        System.out.println(numbers);
        int secondLargestNumber = Arrays
                .stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondLargestNumber);


        //LIST TO MAP
        /*
        Map<Integer, Animal> map = list.stream()
                .collect(Collectors.toMap(Animal::getId, Function.identity()));
        */
        System.out.println("==========Remove Duplicates - Streams=================");
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        List<Integer> listWithoutDuplicates = numbersList.stream().distinct().collect(Collectors.toList());

        System.out.println(listWithoutDuplicates);
        System.out.println("=========Remove Duplicates - Normal==================");

        int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
        int current = input[0];
        ArrayList<Integer> numbersWithoutDuplicate = new ArrayList<>();
        boolean found = false;

        for (int i = 0; i < input.length; i++) {
            if (current == input[i] && !found) {
                found = true;
            } else if (current != input[i]) {
                numbersWithoutDuplicate.add(current);
                current = input[i];
                found = false;
            }
        }
        System.out.print(numbersWithoutDuplicate);


        System.out.println("=========Group by==================");
        List<Student> students = Arrays.asList(
                new Student("Math", "John", "Smith", "Miami", 19),
                new Student("Programming", "Mike", "Miles", "New York", 21),
                new Student("Math", "Michael", "Peterson", "New York", 20),
                new Student("Math", "James", "Robertson", "Miami", 20),
                new Student("Programming", "Kyle", "Miller", "Miami", 20)
        );

        Map<String, List<Student>> studentsBySubject = students
                .stream()
                .collect(
                        Collectors.groupingBy(Student::getSubject)
                );

        System.out.println(studentsBySubject);
        System.out.println("=========Group by==================");


        Map<String, List<String>> namesByCity = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCity,
                        TreeMap::new,
                        Collectors.mapping(Student::getName, Collectors.toList())));

        System.out.println(namesByCity);
        System.out.println("=========Number of occurrence==================");

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,2,3,2,2,2,2,1));
        Map<Integer, Long> result = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result.get(2));
        System.out.println(
                list.stream()
                        .filter(number -> number==2 )
                        .count());

        List<String> list2 = new ArrayList<>(Arrays.asList("Adam", "Bill", "Jack", "Joe", "Ian"));
        Map<Integer, Long> result2 = list2
                .stream()
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));

        System.out.println(result.get(3));


        String s = "Saneera";


        System.out.println(s.chars()
                .filter(ch-> ch == 'e')
                .count());


        System.out.println(s.chars()
                .mapToObj(i-> (char)i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting())));
        System.out.println("=========Reverse element of array==================");


        int[] listtoreverse = {1,2,3,4,5,6,7,8};

        System.out.println(revRange(0,8).toArray()) ;



        List<Integer> list3 = Arrays.asList(1,2,3,4);
        list3.stream()
                .sorted(Collections.reverseOrder()) // Method on Stream<Integer>
                .forEach(System.out::println);


        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(32);
        linkedList.add(90);
        linkedList.add(43);
        linkedList.add(70);
        linkedList.add(20);
        linkedList.add(45);

        int middle = linkedList.size()/2;
        System.out.println(linkedList.get(middle));


    }
}
