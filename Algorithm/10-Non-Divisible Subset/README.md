## Бодлогын өгүүлбэр (Монгол)

Тодорхой бүхэл тоонуудын багц өгөгдсөн бол аль ч тооны нийлбэр нь -д жигд хуваагддаггүй хамгийн дээд дэд олонлогийн хэмжээг хэвлэ.
Жишээ

Үүсгэх боломжтой массивуудын нэг нь . Өөр нэг нь. Бүх сэлгэлтүүдийг шалгасны дараа хамгийн их урттай уусмалын массив элементүүдтэй байна.
Функцийн тодорхойлолт
Доорх засварлагчийн nonDivisibleSubset функцийг гүйцээнэ үү.
nonDivisibleSubset нь дараах параметртэй байна:
int S[n]: бүхэл тоонуудын массив
int k: хуваагч
Буцах
int: шалгуурыг хангасан хамгийн урт дэд багцын урт
Оролтын формат
Эхний мөрөнд хоосон зайгаар тусгаарлагдсан бүхэл тоонууд ба , доторх утгуудын тоо болон хүчин зүйлгүй байна.
Хоёрдахь мөрөнд орон зайгаар тусгаарлагдсан бүхэл тоонууд, тус бүр нь олонлогийн өвөрмөц утгуудыг агуулна.
Хязгаарлалт



Өгөгдсөн тоонууд бүгд ялгаатай.
Жишээ оролт
STDIN функц
----- --------
4 3 S[] хэмжээ n = 4, k = 3
1 7 2 4 S = [1, 7, 2, 4]
Жишээ гаралт
3
Тайлбар
Хоёр элементийн бүх орлуулалтын нийлбэр нь:
1 + 7 = 8
1 + 2 = 3
1 + 4 = 5
7 + 2 = 9
7 + 4 = 11
2 + 4 = 6
Зөвхөн нийлбэрийг хэзээ ч үржвэр болгохгүй.

## Холбоос

https://www.hackerrank.com/challenges/non-divisible-subset/problem?isFullScreen=true


## Нотолгоо, тайлбар


##  `nonDivisibleSubset` Функцийн Тайлбар ба Нотолгоо

###  Зорилго:

Өгөгдсөн бүхэл тоонуудаас **хоёр хоёрын нийлбэр нь `k` тоонд хуваагдахгүй** хамгийн их хэмжээтэй дэд множество (subset)-ийн хэмжээг ол.

---

###  Оролт:

* `k`: Хуваах тоо
* `s`: Давтагдалгүй бүхэл тоонуудын жагсаалт

---

###  Гаралт:

* `s`-ээс сонгож болох хамгийн олон тооны элементийг агуулсан subset-ийн хэмжээ, ийм subset-ийн аль ч 2 элементийн нийлбэр нь `k`-д хуваагдах ёсгүй.

---

###  Үндсэн санаа:

1. Тоон бүрийг `k`-д хувааж **үлдэгдэл**-ийг тооцно.
2. `k` ширхэгийн **үлдэгдэл тоолуур** (`remainderCounts[0..k-1]`) үүсгэнэ.
3. Хэрвээ 2 тооны үлдэгдэл `r` ба `k - r` байвал, эдгээрийг хоёуланг subset-д багтаавал нийлбэр нь `k`-д хуваагдах боломжтой.
4. Иймд `r` болон `k - r`-ын аль илүү олон гишүүнтэйг сонгоно.
5. `r = 0` болон `r = k / 2` (хэрэв `k` нь тэгш) тохиолдолд **нэгээс их элемент багтааж болохгүй**.

---

### Жишээ:

**Оролт:**

```text
k = 3
s = [1, 7, 2, 4]
```

**Үлдэгдэлүүд:**

* 1 % 3 = 1
* 7 % 3 = 1
* 2 % 3 = 2
* 4 % 3 = 1

`remainderCounts = [0, 3, 1]`

* remainder `0` → 0 элемент байна, → 0 эсвэл 1 сонгоно.
* remainder `1` ба `2` → Math.max(3, 1) = 3 сонгоно.

 Хариу: **3**

---

###  Алгоритмын Алхамууд:

```java
int[] remainderCounts = new int[k];

for (int num : s) {
    remainderCounts[num % k]++;
}

int result = 0;

if (remainderCounts[0] > 0)
    result += 1; // зөвхөн нэг 0 үлдэгдэлтэй тоо орж болно

for (int i = 1; i <= k / 2; i++) {
    if (i == k - i) {
        result += 1; // k нь тэгш үед дундах үлдэгдэл
    } else {
        result += Math.max(remainderCounts[i], remainderCounts[k - i]);
    }
}
```

---

###  Цагийн Хүрээ:

* `O(n + k)` — Үлдэгдэл тооцох болон хамгийн ихийг сонгох алгоритм
* `O(k)` — `remainderCounts` массивын хэмжээгээр

---

###  Дүгнэлт:

* Энэ нь тоон олонлогийн бүх хос нийлбэрийг шалгах хэрэггүй хэмнэлттэй алгоритм юм.
* Үлдэгдлийн онцлогийг ашиглан хослолуудаас зайлсхийдэг.
* `k`-ийн дагуу нөхцөлт сонголт хийдэг нь оновчтой бөгөөд хурдан шийдэл болно.

