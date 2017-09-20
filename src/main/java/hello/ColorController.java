package hello;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;
import model.Color;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {


    private final int RANGE = 100;

    private final int RED_PIN = 12;
    private final int GREEN_PIN = 22;
    private final int BLUE_PIN = 24;

    @RequestMapping("/color")
    public ResponseEntity<String> greeting(@RequestParam(value = "color") String colorString) {
        String[] rgbString = colorString.split(",");
        Color rgb = new Color(Integer.valueOf(rgbString[0]), Integer.valueOf(rgbString[1]), Integer.valueOf(rgbString[2]));

        Gpio.wiringPiSetup();

        SoftPwm.softPwmCreate(RED_PIN, 0, RANGE);
        SoftPwm.softPwmCreate(GREEN_PIN, 0, RANGE);
        SoftPwm.softPwmCreate(BLUE_PIN, 0, RANGE);

        setLedColor(rgb);

        return new ResponseEntity<String>(rgb.toString(), HttpStatus.OK);
    }

    public void setLedColor(Color color) {

        SoftPwm.softPwmWrite(RED_PIN, color.getRed());
        SoftPwm.softPwmWrite(GREEN_PIN, color.getGreen());
        SoftPwm.softPwmWrite(BLUE_PIN, color.getBlue());

    }

    @RequestMapping("/test")
    public ResponseEntity<String> test() {

        return new ResponseEntity<String>("worked", HttpStatus.OK);
    }
}