## Бодлогын өгүүлбэр (Монгол)

Хэсэг найзууд баглаа цэцэг худалдаж авахыг хүсч байна. Цэцэгчин шинэ худалдан авагчдын тоо, орлогоо нэмэгдүүлэхийг хүсдэг. Ингэхийн тулд тэр цэцэг бүрийн үнийг тухайн харилцагчийн өмнө нь худалдаж авсан цэцгийн тоо дээр нэмээд үржүүлэхээр шийднэ. Эхний цэцэг нь анхны үнэ, дараагийнх нь байх болно гэх мэт.
Найзуудын бүлгийн хэмжээ, тэдний худалдаж авахыг хүсч буй цэцгийн тоо, цэцгийн анхны үнийг харгалзан бүх цэцэг худалдаж авах хамгийн бага зардлыг тодорхойлно. Тэдний хүсч буй цэцгийн тоо нь массивын урттай тэнцүү байна.
Жишээ


урттай, тиймээс тэд нийт цэцэг худалдаж авахыг хүсч байна. Тус бүр анхны үнээр нь үнэлэгдсэн цэцгүүдээс нэгийг нь худалдаж авна. Жагсаалтын эхний цэцэг болох худалдан авсан цэцэг бүр , үнэтэй болно. Нийт зардал нь .
Функцийн тодорхойлолт
Доорх засварлагчийн getMinimumCost функцийг гүйцээнэ үү.
getMinimumCost дараах параметртэй байна:
int c[n]: цэцэг бүрийн анхны үнэ
int k: найзуудын тоо
Буцах
- int: бүх цэцэг худалдаж авах хамгийн бага зардал
Оролтын формат
Эхний мөрөнд хоёр орон зайгаар тусгаарлагдсан бүхэл тоо, цэцгийн тоо, найзуудын тоо байна.
Хоёр дахь мөрөнд цэцэг бүрийн анхны үнэ болох зайгаар тусгаарлагдсан эерэг бүхэл тоонууд багтана.
Хязгаарлалт




Жишээ оролт 0
3 3
2 5 6
Жишээ гаралт 0
13
Тайлбар 0
Зардалтай цэцэг, бүлэгт хүмүүс байдаг. Хэрэв хүн бүр нэг цэцэг худалдаж авбал төлсөн үнийн нийт зардал нь доллар болно. Тиймээс бид хариултаа хэвлэх болно.
Жишээ оролт 1
3 2
2 5 6
Жишээ гаралт 1
15
Тайлбар 1
Зардалтай цэцэг, бүлэгт хүмүүс байдаг. Бид нийт худалдан авалтын зардлыг дараах байдлаар бууруулж чадна.
Эхний хүн үнэ буурах дарааллаар цэцэг худалдаж авдаг; Энэ нь тэд илүү үнэтэй цэцгийг () эхлээд долларын үнээр, бага үнэтэй цэцгийг () хоёрдугаарт доллараар авдаг гэсэн үг юм.
Хоёр дахь хүн хамгийн үнэтэй цэцгийг долларын үнээр худалдаж авдаг.
Дараа нь бид эдгээр худалдан авалтын нийлбэрийг хэвлэдэг бөгөөд энэ нь бидний хариулт болно.
Жишээ оролт 2
5 3
1 3 5 7 9
Жишээ гаралт 2
29
Тайлбар 2
Найзууд нь , , , болон -ийн үнээр цэцэг худалдаж авдаг.


## Холбоос

https://www.hackerrank.com/challenges/greedy-florist/problem?isFullScreen=true




## Нотолгоо, тайлбар

 Асуудлын нөхцөл:
* Найзууд нийлээд `n` цэцэг авна.
* `k` найз байгаа.
* Цэцгийн эхний үнэ `c[i]`.
* Худалдан авах тус бүр дээр тухайн хүн өмнө хэдэн цэцэг авснаас хамаараад үнэ өснө:

> Цэцгийн үнэ = `original_price * (number_of_previous_purchases + 1)`

* Бүх цэцгийг хамгийн хямдаар авах арга замыг олох.


 Алгоритмын санаа:

1. **Ихэнх үнэтэй цэцгийг түрүүлж авна**
   Хамгийн үнэтэй цэцгийг хамгийн бага multiplier буюу `1`-тэй удаа авах нь зардлыг багасгана.

2. **Цэцгийг үнэ буурахаар эрэмбэлэх**
   Үнэтэй цэцгүүдийг эхэнд нь авах боломжийг бүрдүүлэх.

3. **Хамгийн үнэтэй цэцгээс эхлэн ээлж дараалан авах**
   Найзууд ээлжлэн авна. Үүний тулд multiplier-ийг `(i / k) + 1` гэж тооцно, яагаад гэвэл `i`-ийн байрлалаас хамаарч тухайн хүн хэд дэхь удаагаа цэцэг авч байгааг тоолно.

 Жишээ (3 цэцэг, 2 найз):

* Цэцгийн үнэлгээ: `[2, 5, 6]`
* Эрэмбэл: `[6, 5, 2]`

| Цэцэг дугаар | multiplier | Үнийн бодлого              | Төлбөр |
| ------------ | ---------- | -------------------------- | ------ |
| 1-р цэцэг    | 1          | 6 \* 1 = 6                 | 6      |
| 2-р цэцэг    | 1          | 5 \* 1 = 5                 | 5      |
| 3-р цэцэг    | 2          | 2 \* 2 = 4 (1-р хүн дахин) | 4      |

Нийт төлбөр = 6 + 5 + 4 = 15

 Нотолгоо:

* Хэрвээ үнэтэй цэцгийг дарааллын хамгийн эхэнд авахгүй бол илүү өндөр multiplier-ээр үнэтэй цэцэг авч төлбөр их болно.
* Эцсийн төлбөрийг бууруулахын тулд хамгийн үнэтэй зүйлсийг хамгийн бага multiplier-тэй авах ёстой.
* Энэ greedy арга нь хамгийн хэмнэлттэй төлбөрийг баталдаг.

 Дүгнэлт:

* Цэцгүүдийг буурахаар эрэмбэлж авна.
* Ээлжлэн худалдан авалт бүр дээр multiplier нэмэгдэнэ.
* Ийнхүү бүх цэцгийг хамгийн хямдаар авах боломжтой.

