API Nedir? ● API ==> Application Programming Interface. ● API’ nin UI (User Interface - Kullanıcı Arayüzü) yok

API’ ı bir restoranda garson olarak düşünelim. Bir garson olarak, API bir istemciden bir istek alır (Request), bu isteği veri tabanına alır, istenen verileri veri tabanından alır ve istemciye bir yanıt (Response) döndürür.

API Testi Nedir? API testi, API‘ ın bir uygulamanın işlevselliği, güvenilirliği, performansı ve güvenliği açısından beklentileri karşılayıp karşılamadığını kontrol etmek için yapılır. API testi uygulamanın görnümü ile ilgilenmez.

HTTP Nedir? HTTP ==> Hyper Text Transfer Protocol İstemci (Client) bilgisayarlar ve web sunucuları arasındaki iletişim, HTTP Request ve HTTP Response göndererek yapılır. İstemciler (Client) genellikle tarayıcılardır (Chrome, Edge, Safari), ancak herhangi bir program veya cihaz türü olabilirler. Sunucular (Server) genellikle buluttaki bilgisayarlardır. Client ve Server arasındaki iletişim, request ve response lar ile yapılır:: 1.Bir Client (bir tarayıcı) web'e bir HTTP Request gönderir. 2. Bir Web Server Request’i alır. 3. Server, Request’i işlemek için bir uygulama çalıştırır. 4. Server tarayıcıya bir HTTP Response (çıktı) gönderir. 5. Client (Browser) Response’u alır.

API Testinde Tam Olarak Neyin Doğrulanması Gerekir? API testinde, bizler API’a bilinen verilerle bir istek göndeririz ve cevabı test ederiz.

Ortak HTTP Status Kodları

200 (OK) ==> Talep karşılandı. Request gerçekleşti.
201 (CREATED) ==> Database’ e gönderilen datanın oluşturulduğunu söyler. (200 olarak da gelebilir)
204 (NO CONTENT) ==> Talep yerine getirildi ancak size cevap (response) dönemiyoruz.
400 (BAD REQUEST) ==> Syntax yanlış, yüksek boyutlu data ya da diğer kullanıcı hatası...
403 (FORBIDDEN) ==> Bu dataya erişim izniniz yok. (400 olarak da gelebilir)
404 (NOT FOUND) ==> Aranılan data bulunamadı.
500 (INTERNAL SERVER ERROR) ==> Server kaynaklı bir hatadır, server’ın düzelmesini bekleriz.
API Testlerinde Hani Programları Kullanırız?

Postman Postman, geliştiricilerin API’ları oluşturmasını, paylaşmasını ve test etmesini ve belgelemesini sağlayan popüler bir uygulamadır.

SOAP UI SOAP  Simple Object Access Protocol. (Basit Nesne Erişim Protokolü) Web uygulamalarının internet üzerinden haberleşebilmesi önemlidir. HTTP, tüm internet tarayıcıları ve sunucuları tarafından desteklendiğinden, uygulamalar arasında iletişim kurmanın en iyi yolu HTTP üzerindendir. SOAP bunu başarmak için oluşturulmuştur. SOAP, farklı teknolojiler ve programlama dilleri ile farklı işletim sistemlerinde çalışan uygulamalar arasında iletişim kurmak için bir yol veya biçim sağlar. SOAP platformlardan bağımsızdır.

REST / RestFul REST ==> REpresentational State Transfer REST sistemlerin birbirleri ile iletişim kurmalarını kolaylaştırır. REST mimarisinde, client’ lar dataları almak (retrive) veya değiştirmek (modify) için request gönderir ve server’lar bu request’lere response gönderir.

Bir REST Request’i Nelerden Oluşur?

Bir HTTP yöntemi, ne tür bir işlemin gerçekleştirileceğini tanımlar. A) GET , dataları okumak içindir. B) POST , yeni data oluşturmak içindir. C) PUT dataları tamamen güncellemek içindir. D) PATCH, dataları kısmen güncellemek içindir. E) DELETE, dataları silmek içindir.

HEADER (Başlık)‘da, istemci (Client) sunucudan alınacak içeriğin türünü gönderir. Header (Başlık), sunucunun istemci tarafından anlaşılamayan veya işlenemeyen verileri göndermemesini sağlar. Bir kaynağa PATH (Yol) (Endpoint/URL/URI) oluşturma : İstekler (Request), işlemin gerçekleştirileceği bir kaynağa giden yolu içermelidir. Bitiş Noktası (Endpoint) bu şekilde olacaktır, www.fashionboutique.com/customers

API Endpoint Nedir? API’ın istek gönderdiği ve kaynagın yaşadığı yer endpoint’tir. API developer’lar bir API oluşturduğunda genel endpoint’ler (URL) oluştururlar ve hangi endpoint’in hangi HTTP Request yöntemleriyle çalışacağına karar verirler. Testerlar aşağıdaki komutları kullanarak, beklendiği gibi çalışırsa, tüm endpoint’leri test ederler. GET, POST, PUT, DELETE HTTP Request

Swagger Nedir? Swagger, API’ nızın, zayıf kaynak kodu bilgisine sahip olsalar bile geliştiriciler ve testerlar tarafından okunması ve anlaşılması kolay ortak bir dil kullanarak tanımlamak için bir framework’tür. Bunu bir ev planı gibi düşünebilirsiniz. İstediğiniz yapı malzemesini kullanabilirsiniz ancak evin planının dışına çıkamazsınız. API belgeleri için SWAGGER kullandım. SWAGGER bana API endpoint’leri veriyor ve bunların nasıl kullanılacağı hakkında beni bilgilendiriyor.
