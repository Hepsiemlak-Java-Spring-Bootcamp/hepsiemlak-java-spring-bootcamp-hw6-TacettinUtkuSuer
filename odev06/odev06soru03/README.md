##  170. Hepsiemlak Java Spring Bootcamp

###### Tacettin Utku Süer



#### Ödev 6 Soru 3 - Rest Servis Versiyonlama



Çalışan ve kullanılan bir servise zaman içinde yeni özellikler kazandırmak istediğimizde geriye dönük olarak uyumlu olması eski API'yı kullanan kullancıların bundan etkilenmemesini sağlamak için API'mızı versiyonlamamız gerekmektedir. Bu sayede mevcut işlevsellik korunurken daha fazla işlevselliğe sahip yeni versiyonuda eklemiş oluruz.



Çok kullanılan üç tane Rest servis versiyonalama yöntemi vardır.



##### 1. URI versiyonlama

http://web.domain.com/v2/user yada http://webv2.domain.com/user gibi URI üzerinden versiyonlama yapılabilir. Burda versiyonun nümerik değil yazı veya yazı nümerik kombinasyonu olması gerekmektedir. Twitter bu yöntemi kullanmaktadır. 



##### 2. Custom Request Header

Sürüm bilgisi URL'de herhangi bir değişiklik yapmamıza gerek kalmadan istek başlığında belirtilerek versiyonlama yapılır. Microsoft bu yöntemi kullanmaktadır.



##### 3. Accept Header

URL'i değiştirmeden üstbilgiler aracılığı ile sürüm bilgileri iletilebilmektedir. http://web.domain.com/user/param?version=1, örnek olarak gösterilebilir. GitHub bu yöntemi kullanmaktadır.
