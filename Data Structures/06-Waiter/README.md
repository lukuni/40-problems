## Бодлогын өгүүлбэр (Монгол)

Та үдэшлэгт зөөгч байна. овоо дугаарласан хавтан байна. Хоосон массив үүсгэ. Давталт бүрт, , хавтан бүрийг стекийн дээд хэсгээс дарааллаар нь салга. Хавтан дээрх тоо анхны тоонд тэгш хуваагдах эсэхийг тодорхойл. Хэрэв тийм бол овоолж овоолно уу. Үгүй бол үүнийг стек болгон овоолно уу. Утгыг дээрээс доош нь хадгална. Дараагийн давталтанд стек дэх утгуудтай ижил зүйлийг хий. Шаардлагатай тооны давталт дууссаны дараа үлдсэн утгуудыг дээрээс доош нь дахин дотор хадгална. Массивыг буцаана уу.
Жишээ


Анхны тоонуудын товчилсон жагсаалт нь . Хавтанг урвуу дарааллаар овоолно.


Давталтуудыг эхлүүлэх. Эхний давталт дээр зүйлүүд хуваагдаж байгаа эсэхийг шалгана уу.


Элементүүдийг .

Хоёрдахь давталт дээр элементүүд нь -д хуваагдах эсэхийг шалгана.


Элементүүдийг .

Гурав дахь давталт дээр элементүүд нь -д хуваагдах эсэхийг шалгана уу.


Элементүүдийг .

Бүх давталтууд дууссан тул үлдсэн элементүүдийг дээрээсээ доош руу шилжүүлнэ үү.
. Энэ жагсаалтыг буцаана уу.
Функцийн тодорхойлолт
Доорх засварлагчийн зөөгчийн функцийг гүйцээнэ үү.
зөөгч дараах параметрүүдтэй байна.
int тоо[n]: ялтсууд дээрх тоонууд
int q: давталтын тоо
Буцах
int[n]: боловсруулсны дараа ялтсууд дээрх тоонууд
Оролтын формат
Эхний мөрөнд зайгаар тусгаарлагдсан хоёр бүхэл тоо, мөн .
Дараагийн мөрөнд эхний овоолгын ялтсуудыг төлөөлөх зайгаар тусгаарлагдсан бүхэл тоонууд орно, өөрөөр хэлбэл, .
Хязгаарлалт



Жишээ оролт 0
5 1
3 4 7 6 5
Жишээ гаралт 0
4
6
3
7
5
Тайлбар 0
Эхэндээ: 
= [3, 4, 7, 6, 5]<-ТОП
1 давталтын дараа (1-р анхны тоо болох 2-т хуваах): 
= [5, 7, 3]<-ТОП 
= [6, 4]<-ТОП
Элементүүдийг .

Бүх давталтууд дууссан тул элементүүдийг .
.
Жишээ оролт 1
5 2
3 3 4 4 9
Жишээ гаралт 1
4
4
9
3
3
Тайлбар 1
Эхэндээ: 
= [3, 3, 4, 4, 9]<-ТОП
Давталтын дараа (2-т хуваах): 
= [9, 3, 3]<-ТОП 
= [4, 4]<-ДЭЭД
руу шилжих.

Давталтын дараа (3-т хуваах): 
= []<- ДЭЭД 
= [3, 3, 9]<-ТОП
Элементүүдийг .

-д үлдсэн утга байхгүй.


## Холбоос

https://www.hackerrank.com/challenges/waiter/problem?isFullScreen=true




## Нотолгоо, тайлбар

1.  **Цагийн хязгаараас хэтрэх (Time Limit Exceeded - TLE):**
    * **Комплекс байдлын шинжилгээ:**
       
        * **Анхны тоо үүсгэх (`generatePrimes`):** `q` нь 1000 хүртэл байж болох бөгөөд 1000 дахь анхны тоо нь 7919 орчим юм. Анхны тоог шалгах давталт (`for (int i = 2; i <= Math.sqrt(num); i++)`) нь $O(\sqrt{\text{num}})$ хугацаа зарцуулдаг. Гадна талын давталт нь `num`-г 7919 хүртэл гүйлгэдэг. Энэ хэсэг нь нийт $P_q \cdot \sqrt{P_q}$ орчим үйлдэл хийх бөгөөд $q=1000$ үед энэ нь ойролцоогоор $7919 \cdot 89 \approx 7 \cdot 10^5$ үйлдэл болно. Энэ нь хурдан тул TLE-ийн гол шалтгаан биш.
        
        
        * **Үндсэн логик (`waiter`):**
            * Гадна талын давталт `q` удаа ажиллана.
            * Энэ давталтын доторх `while (!A.isEmpty())` давталт нь `A` стэйк дэх бүх хавтанг боловсруулна. Хамгийн муу тохиолдолд `A` нь бүх `N` хавтанг агуулж болно. `Stack` дээрх `pop()` болон `push()` үйлдэл тус бүр нь $O(1)$ хугацаатай.
            * Иймээс, гадна талын давталтын нэг удаагийн гүйцэтгэл нь `N` хавтанг боловсруулж, $O(N)$ үйлдэл хийнэ.
            * Нийт хугацааны комплекс байдал: $O(q \cdot N + \text{анхны тоо үүсгэх})$.
            * Өгөгдсөн хязгаарлалтууд: $N \le 10^5$, $q \le 10^3$.
           
            * Хамгийн муу тохиолдолд үйлдэл: $10^3 \cdot 10^5 = 10^8$ үйлдэл.
    * **Дүгнэлт:** $10^8$ үйлдэл нь ихэвчлэн 1-2 секундын цагийн хязгаарт яг таардаг эсвэл бага зэрэг давдаг үзүүлэлт юм. Хэрэв `java.util.Stack`-ийн үйл ажиллагааны тогтмол коэффициент өндөр эсвэл тест хийгдэж буй сервер удаан бол энэ нь амархан TLE-д хүргэж болно.

2.  **Санах ойн алдаа (OutOfMemoryError):**
    * Таны `A`, `Anew`, `B` стэйкүүд нь `Integer` объектуудыг хадгалдаг. Хамгийн ихдээ `N = 10^5` элемент байж болно. `10^5` ширхэг `Integer` объект (тус бүр нь хэдэн арван байт) нь хэдхэн мегабайт болно. Энэ нь ихэвчлэн зөвшөөрөгдөх санах ойн хязгаарт (ихэвчлэн 256MB эсвэл 512MB) багтана. Тиймээс, энэ нь байх магадлал багатай.

### Шийдэл: Stack үйлдлүүдийг оновчтой болгох

`java.util.Stack` нь хуучин (legacy) класс бөгөөд `synchronized` буюу нэгэн зэрэг ажиллах боломжтой байдлыг зохицуулдаг учир нэмэлт ачаалал үүсгэдэг. Таны шийдэл шиг, ганц урсгалтай (single-threaded) програмуудад **`java.util.ArrayDeque`** нь ихэвчлэн илүү хурдан байдаг бөгөөд стэйкийн үйлдлүүдэд илүү тохиромжтой.

 `ArrayDeque` ашиглахаар өөрчилсөн байдал:**

Зүгээр л `Stack` үүсгэсэн хэсгүүдийг `Deque` (интерфэйс) ба `ArrayDeque` (имплементац) болгож өөрчлөхөд хангалттай.

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.Deque;    // Deque интерфейсийг оруулж ирнэ
import java.util.ArrayDeque; // ArrayDeque имплементацийг оруулж ирнэ

class Result {

    private static List<Integer> generatePrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < q) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> result = new ArrayList<>();
        List<Integer> primes = generatePrimes(q);

        // Stack-ийн оронд ArrayDeque-г ашиглана, энэ нь илүү хурдан ажилладаг.
        Deque<Integer> A = new ArrayDeque<>();
        for (int plate : number) {
            A.push(plate); // push нь deque-ийн "оройд" (урд талд) нэмнэ
        }

        for (int i = 0; i < q; i++) {
            Deque<Integer> Anew = new ArrayDeque<>(); // Давталт бүрт шинэ ArrayDeque үүсгэнэ
            Deque<Integer> B = new ArrayDeque<>();
            int prime = primes.get(i);

            while (!A.isEmpty()) {
                int plate = A.pop(); // pop нь deque-ийн "оройгоос" (урд талаас) устгана
                if (plate % prime == 0) {
                    B.push(plate);
                } else {
                    Anew.push(plate);
                }
            }

            while (!B.isEmpty()) {
                result.add(B.pop());
            }

            A = Anew; // Anew нь дараагийн давталтын A болно
        }

        while (!A.isEmpty()) {
            result.add(A.pop());
        }

        return result;
    }
}

// Таны Solution класс оролт/гаралтыг зохицуулах хэвээр байна
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}