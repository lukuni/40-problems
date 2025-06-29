## Бодлогын өгүүлбэр (Монгол)

Өгөгдсөн мөр (string)-ийн бүх боломжит substring-үүдийн хооронд ананограм болох хосуудын тоог олоорой.

Ананограм гэдэг нь хоёр мөрний үсгүүдийг эрэмбэлэлтгүйгээр (rearrange) өөрчилж, нэгийг нь нөгөөгөөр бүрдүүлж болохыг хэлнэ.

Жишээ нь: "abba" мөрийн substring-үүдээс "ab" ба "ba" бол ананограм, мөн "abb" ба "bba" гэсэн хосууд ананограм байна.

Таны даалгавар нь:
- Өгөгдсөн мөрийн бүх substring-үүдийг авч,
- Ананограм хосуудыг тоолж,
- Ананограм хосуудын тоог буцаах.

Sample Input 0: 
2
abba
abcd

Sample Output 0:
4
0

## Холбоос

- [HackerRank: Sherlock and Anagrams](https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true)



##  Нотолгоо тайлбар

- Мөрний бүх substring-ийг авч, үсгүүдийн тоо бүрэлдэхүүнээр (эсвэл сортлосон дарааллаар) бүлэглэнэ.
- Жишээ: "abba" -ийн substring-үүдийг авч үзвэл:
  - урт 1: a, b, b, a
  - урт 2: ab, bb, ba
  - урт 3: abb, bba
  - урт 4: abba
- Ижил сортлогдсон substring-үүд хооронд ананограм бий. Тиймээс ижил key-тэй substring-үүдийг бүлэглэж, бүлгийн хэмжээнээс `n * (n - 1) / 2` тооцоолно.
- Энэ нь бүх боломжит ананограм хосуудын тоог өгнө.
