telapi-java
==========

This java library is an open source tool built to simplify interaction with the [TelAPI](http://telapi.com) telephony platform. TelAPI makes adding voice and SMS to applications fun and easy.

For more information about TelAPI, please visit:  [telapi.com/features](http://www.telapi.com/features) or [telapi.com/docs](http://www.telapi.com/docs)

---


Installation
============

Usage
======

### REST

[TelAPI REST API documenatation](http://www.telapi.com/docs/api/rest/) 

##### Send SMS Example

```java
package com.telapi.api.example;
 
import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.exceptions.TelapiException;
 
public class SendSmsExample {
    public static void main(String[] args) {
        BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
        conf.setSid("********************************");
        conf.setAuthToken("********************************");
        TelapiConnector conn = new TelapiConnector(conf);
 
        try {
            SmsMessage smsMessage = conn.sendSmsMessage(
                "(XXX) XXX-XXXX",
                "(XXX) XXX-XXXX",
                "This is an SMS message sent from the TelAPI Java helper! Easy as 1, 2, 3!",
                null
            );
            System.out.println(smsMessage.getSid());
        } catch (TelapiException e) {
            e.printStackTrace();
        }
    }
}         
```

### InboundXML

InboundXML is an XML dialect which enables you to control phone call flow. For more information please visit the [TelAPI InboundXML documenatation](http://www.telapi.com/docs/api/inboundxml/)

##### <Say> Example

```java
package com.telapi.api.inboundxml.example;
 
import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.elements.enums.Voice;
 
public class SayExample {
 
public static void main(String[] args) {
 
    Response.create()
        .say("Welcome to TelAPI. This is a sample InboundXML document.", Voice.MAN)
        .createXml();
 
    }
 
}   
```

will render

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response>
  <Say voice="man">Welcome to TelAPI. This is a sample InboundXML document.</Say>
</Response>
```

---
