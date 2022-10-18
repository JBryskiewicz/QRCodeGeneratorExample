package pl.me.qrgen;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.BufferedImage;

@Controller
public class AppController {

    @GetMapping("/QRCode-generator")
    public String generateQRCode(){
        return "generator_input";
    }

    @PostMapping(value = "/QRCode-printer", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<BufferedImage> receiveQRCode(@RequestParam String barcodeText) throws Exception{
        try{
            return ResponseEntity.ok(QRGenerator.generateQRCodeImage(barcodeText));
        }catch (IllegalArgumentException e){
            return ResponseEntity.ok(null);
        }
    }
}
