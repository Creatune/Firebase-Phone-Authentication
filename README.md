# Firebase-Phone-Authentication
Android Developer Test at Roz:

1. This is a simple signup/login app using phone authentication in Firebase.
2. The starting screen takes the phone number and country zone, parses them together accordingly, and sends this data to the next activity        (phoneVerificationActivity).
3. Once the next activity starts, firebase sends the verification code and the activity automatically gets the sms code (explicitly coded) and enters it.
4. Once the verification is complete, the dashboardActiviy becomes the startup activity and clears previous activity history. Thus, if the user kills the activity and reopens it, the user will be signed in by default unless he/she logs out. 
