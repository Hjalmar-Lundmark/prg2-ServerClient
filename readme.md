# Chatprogram

Jag vill först få ett fungerande MVC och GUI innan 
jag börjar med att fixa in egna saker. För de egna 
sakerna hade jag tänkt något "bot" liknande med 
inprogrammerade svar, till en början iaf. 


## Logg

9/2: Börjat med MVC, specifikt i client hittils. 
Minns inte exakt så kopierar en del från crypt-projektet
och försöker göra något vettigt av den grunden. 
Är också lite osäker vad som ska vara i Model. 

10/2: Fortsatt bygga MVC. Inte kommit långt med 
Model men resten har gått bra. 

16/2: Fortsatte med MVC och skrev om V&C en del 
från genomgången, View syns nu när start/controller 
startas. Jag är osäker på vad modelen ska innehålla, 
om den ska vara sin egen grej med bara lite import 
från ListenerThread, eller om Model ska importera från 
Client. Testar mig fram i Model. 

17/2: Gjort mycket i Klientens Model och Controller. 
Inte lyckats med ett fungerande protocol än dock. 

23/2: Faktiskt gjort att de kopplar upp med varann och 
nu fungerar skickande av meddelanden åt båda håll. 
Problemmet var att ListenerThread skrev ut i System.out 
istället för i View. 

24/2: Gjort en början till "bot / command" funktion 
och bytt logotyp. Inga problem. 

02/3: Sjuk :(

03/3: Gjort några commands, ändrat font, 
gjort input för ip. 