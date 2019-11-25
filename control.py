#!/usr/bin/python3

import RPi.GPIO as GPIO
import time

GPIO.setwarnings(False)

HygroPin = 17
ledPin = 4

file = open('test.txt','w')

GPIO.cleanup()

#set our GPIO numbering to BCM
GPIO.setmode(GPIO.BCM)

GPIO.setup(HygroPin,GPIO.IN)
GPIO.setup(ledPin, GPIO.OUT)

try:
        while True:
                if GPIO.input(HygroPin) == 0:
                        file.seek(0)
                        file.write("Happy Plant!\n")
                        file.truncate()
                        GPIO.output(ledPin,False)
                        print("written")
                else:
                        file.seek(0)
                        file.write("Thirsty Plant..\n")
                        file.truncate()
                        GPIO.output(ledPin,True)
                        print("written")
                time.sleep(.1)

except:
        GPIO.cleanup()





