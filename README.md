Java 测试
==

[![Build Status](https://travis-ci.org/MurphyL/CaseJava.svg?branch=master)](https://travis-ci.org/MurphyL/CaseJava)


## 其他的一些内容

1. Java8 以下不支持 java.lang.reflect.Method.getParameterTypes() 以及 java.lang.reflect.Method.getParameterCount()；


#### 反序列化测试代码

```java
    public static void main(String[] args) throws Exception {
        FileOutputStream fs = new FileOutputStream("d:\\c.txt");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(new CommissionRateResponse(ResponseCode.BADREQUEST, null));
        os.flush();
        os.close();

        FileInputStream fis = new FileInputStream("d:\\c.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        CommissionRateResponse o = (CommissionRateResponse)ois.readObject();
        System.out.println(JSON.toJSONString(o, true));
        ois.close();
    }
```
