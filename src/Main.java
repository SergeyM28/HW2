import java.util.Random;

/*      1. Доделатьсортировку подсчетом с урока (если нет, реализовать) классическим способом через промежуточный массив
        (см. последние минут 10 семинара)
        2. Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифро- вания и числовым ключом;
        3. Написать метод, принимающий на вход массив чисел и параметр n. Метод должен осуществить циклический
        (последний элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций;
*/
public class Main {
    public static void main(String[] args) {

        // Задача 1.
        System.out.println("Задание 1");

        int arraySize = 50;
        int lowestValue = -3;
        int upperValue = 3;

        // Создание массива для сортировки

        Random rd = new Random();
        int[]array = new int[arraySize];
        for(int i = 0; i < array.length; i++){
            array[i] = rd.nextInt(lowestValue, upperValue + 1);
        }

        // Сортировка подсчетом. Вся логика в классе ArrayProcessor

        ArrayProcessor ap = new ArrayProcessor(array);
        ap.printArray();
        ap.countingSort();
        ap.printArray();

        System.out.println("_____________________");

        //Задача 2.
        System.out.println("Задание 2");

        String a = "я памятник себе воздвиг нерукотворный!";
        String b = "";
        String c = "";
        CaesarCipher cc = new CaesarCipher();
        b = (cc.doCaesarEncryption(true, a, 3)); // true для зашифровки, false для расшифровки
        c = (cc.doCaesarEncryption(false, b, 3));
        System.out.println("ввод -> " + a);
        System.out.println("шифр -> " + b);
        System.out.println("расшифровка -> " + c + "\n");

        System.out.println("_____________________");

        //Задача 3.
        System.out.println("Задание 3");

        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayProcessor ap2 = new ArrayProcessor(array2);
        ap2.printArray();
        ap2.shiftArray(3); //сдвиг вправо на 3
        ap2.printArray();
        }







}