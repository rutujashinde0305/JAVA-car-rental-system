create database project;
CREATE TABLE CAR (
    CAR_NO VARCHAR(50) PRIMARY KEY,
    CAR_PRICE INT,
    FUEL_TYPE VARCHAR(30),
    PD_PRICE INT,
    SEATS INT,
    CAR_BRAND VARCHAR(30),
    CAR_COLOR VARCHAR(20),
	CAR_ADV int
);


create table rent(
	CAR_NO VARCHAR(50),
	FOREIGN KEY (CAR_NO) REFERENCES CAR (CAR_NO) ON DELETE CASCADE,
	CUS_ID INT ,
	CUS_NAME VARCHAR(30),
    ADDRESS VARCHAR(30),
    CUS_PNUM VARCHAR(10),
    CUS_EMAIL VARCHAR(30),
	rent_ID INT AUTO_INCREMENT PRIMARY KEY,
	rent_date DATE,
    return_date DATE
);

 insert into rent values("MH12AB1235",2,"pratiksha","undawadi",1234533,"rs@gmail.com",1,'2024-02-02','2024-03-04');
 
 
 
 
 String query = "SELECT * FROM CAR LEFT JOIN rent ON CAR.CAR_NO = rent.CAR_NO WHERE rent.rent_ID IS NULL AND CAR_BRAND = ?";
				PreparedStatement pstmt = cn.prepareStatement(query);
				pstmt.setString(1, bf.getText()); // Set the parameter value
				ResultSet rs = pstmt.executeQuery();
				
				
				
				
				
create table earning(
	CAR_NO VARCHAR(50),
	FOREIGN KEY (CAR_NO) REFERENCES CAR (CAR_NO) ON DELETE CASCADE,
	rent_ID INT AUTO_INCREMENT PRIMARY KEY,
	CUS_ID INT ,
	PD_PRICE INT,
	rent_date DATE,
    return_date DATE,
	CAR_ADV int
);