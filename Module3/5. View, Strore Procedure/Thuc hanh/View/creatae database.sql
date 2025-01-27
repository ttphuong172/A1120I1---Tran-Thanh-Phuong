create database classicmodels;
use classicmodels;
create table customers(
customerNumber int not null  key,
customerName varchar(255) not null,
contactLastName varchar(255) not null,
contactFirstName varchar(255) not null,
phone  varchar(255) not null,
addressLine1 varchar(2555)
);

insert into customers(customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1)
values
(1,"Casey","Jillian","Wilma","(0114) 019 5155","P.O. Box 991, 4619 Semper Avenue"),(2,"Wyoming","Shaeleigh","Kathleen","0910 017 8180","P.O. Box 367, 6643 Commodo St."),(3,"Gabriel","Myles","Ori","0500 514858","960-5651 Velit Street"),(4,"Kessie","Colleen","Dakota","0931 843 9283","9417 Pede, St."),(5,"Nadine","Jonah","Candace","(0117) 086 7511","719-2778 Ullamcorper St."),(6,"Ursa","Josephine","Lewis","0500 681973","8445 Ut Road"),(7,"Damian","Quin","Skyler","0500 404205","P.O. Box 474, 2874 Sociis Street"),(8,"Sara","Liberty","Genevieve","0800 563117","155-1222 Aliquam Rd."),(9,"Ian","Rina","Samson","0845 46 46","Ap #944-1701 Diam St."),(10,"Hiram","Kelsie","Clark","0800 1111","Ap #440-3040 Lacus Avenue"),
(11,"Keith","Summer","Brock","0800 172 0514","6668 Dapibus Avenue"),(12,"Charde","Gretchen","Edan","056 9959 2637","Ap #935-1171 Vulputate, Road"),(13,"Ursa","Martha","Nicholas","076 6544 0306","235-748 Magna Ave"),(14,"Claire","Dylan","Maisie","056 8692 1569","9000 Dui. Rd."),(15,"Martina","Justine","Xavier","(01359) 85010","Ap #897-6849 Elementum Road"),(16,"Daniel","Neville","Cora","(0114) 822 5878","5405 Auctor Rd."),(17,"Caryn","Madonna","Melvin","055 4122 7278","3471 Nunc Avenue"),(18,"Maggy","Demetrius","Xavier","(01073) 62046","488-5591 Elit Road"),(19,"Tiger","Chiquita","Sydnee","0500 091227","Ap #492-3650 Nibh St."),(20,"Lacy","Beau","Linus","(024) 7423 5758","1887 Cras Ave");

