The name of NOVA is from my study-group when I am pursing master degree in USC.
It is also the name of the 'wild women' name in the movie <Planet of the Apes>.
Honestly, I hate ignorance but platform such as coursera and udemy provide people a good environment.

This is the largest project I have ever attend and lead.
To write build a comprehensive MOOC website like Coursera and Udemy
is always my dream.

I learn a lot from them. 


Basically, a application based on SpringBoot and Microservices will include below
parts:

parent-module:used only to version and dependencies management.

utils-module: used to store some utils class.

api-module: an independent module to build design and implement apis.

model-module: obey MVC-development rules, to store data's model.

common: build some common and overall classes, including exceptions, some error code, request and response code...

Additionally, during our development process, we will append and revise some new modules into our architecture.

The core-part of this project is CMS service, so we build it at first.
 After that, all other services are used to interact with CMS module.

