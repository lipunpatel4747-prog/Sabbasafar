import os
import time
import random

# Ye function phone ko swipe karne ka command bhejega
def swipe(direction):
    print(f"Swiping {direction}...")
    if direction == "left":
        os.system("adb shell input swipe 500 1000 100 1000 100")
    elif direction == "right":
        os.system("adb shell input swipe 500 1000 900 1000 100")
    elif direction == "up":
        os.system("adb shell input swipe 500 1000 500 500 100")
    elif direction == "down":
        os.system("adb shell input swipe 500 1000 500 1500 100")

# Main loop (Abhi ke liye yeh random swipes karega)
print("Bot start ho gaya bhai! Band karne ke liye Ctrl+C dabana.")
try:
    while True:
        # Abhi hum AI nahi laga rahe, bas random swipe kar rahe hain test ke liye
        action = random.choice(["left", "right", "up", "down"])
        swipe(action)
        time.sleep(1) # 1 second ka gap
except KeyboardInterrupt:
    print("\nBot band ho gaya.")
