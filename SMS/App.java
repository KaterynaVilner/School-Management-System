package com.perscholas.SMS;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import jpa.entitymodels.*;

/* The data inserted into the MySQL table
insert into Student (email, name, password) values ('hluckham0@google.ru', 'Hazel Luckham', 'X1uZcoIh0dj');
insert into Student (email, name, password) values ('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU');
insert into Student (email, name, password) values ('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd');
insert into Student (email, name, password) values ('cstartin3@flickr.com', 'Clem Startin', 'XYHzJ1S');
insert into Student (email, name, password) values ('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz');
insert into Student (email, name, password) values ('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs');
insert into Student (email, name, password) values ('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ');
insert into Student (email, name, password) values ('aiannitti7@is.gd', 'Alexandra Iannitti', 'TWP4hf5j');
insert into Student (email, name, password) values ('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP');
insert into Student (email, name, password) values ('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6');
 */


public class App 
{
    public static void main( String[] args )
    {
    	 SessionFactory factory = new Configuration().configure().buildSessionFactory();
         Session session = factory.openSession();
         Transaction t = session.beginTransaction();
         //create two tables
      /*   Student sone = new Student();
         Course cone = new Course();
         t.commit();
         System.out.println("successfully created tables");
         factory.close();
         session.close();*/
         
         //populate the Student_Course table
         Student hazel = session.createQuery("FROM Student WHERE sName = :name", Student.class).setParameter("name", "Hazel Luckham").getSingleResult();
         Student sonni = session.createQuery("FROM Student WHERE sName = :name", Student.class).setParameter("name", "Sonnnie Bowden").getSingleResult();
         Student quillan = session.createQuery("FROM Student WHERE sName = :name", Student.class).setParameter("name", "Quillan Llorens").getSingleResult();
         Student clem = session.createQuery("FROM Student WHERE sName = :name", Student.class).setParameter("name", "Clem Startin").getSingleResult();
         Student thorni = session.createQuery("FROM Student WHERE sName = :name", Student.class).setParameter("name", "Thornie Attwool").getSingleResult();

         Course eng = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "English").getSingleResult();
         Course math = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Mathematics").getSingleResult();
         Course anat = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Anatomy").getSingleResult();
         Course chem = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Organic Chemistry").getSingleResult();
         Course phys = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Physics").getSingleResult();
         Course dl = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Digital Logic").getSingleResult();
         Course oop = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Object Oriented Programming").getSingleResult();
         Course ds = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Data Structures").getSingleResult();
         Course pol = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Politics").getSingleResult();
         Course art = session.createQuery("FROM Course WHERE cName = :name", Course.class).setParameter("name", "Art").getSingleResult();
       
         List<Course> sone = new ArrayList<Course>();
         sone.add(chem);
         sone.add(eng);
         List<Course> stwo = new ArrayList<Course>();
         stwo.add(art);
         stwo.add(pol);
         stwo.add(ds);
         List<Course> sthree = new ArrayList<Course>();
         sthree.add(oop);
         sthree.add(dl);
         List<Course> sfour = new ArrayList<Course>();
         sfour.add(phys);
         sfour.add(anat);
         List<Course> sfive = new ArrayList<Course>();
         sfive.add(math);
         sfive.add(phys);
         sfive.add(oop);
         
         hazel.setsCourses(sone);
         sonni.setsCourses(stwo);
         quillan.setsCourses(sthree);
         clem.setsCourses(sfour);
         thorni.setsCourses(sfive);
         
         session.update(hazel);
         session.update(sonni);
         session.update(quillan);
         session.update(clem);
         session.update(thorni);
         t.commit();
         System.out.println("successfully updated tables");
         factory.close();
         session.close();
         
         
    }
}
