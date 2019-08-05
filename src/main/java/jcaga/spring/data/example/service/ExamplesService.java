package jcaga.spring.data.example.service;

import jcaga.spring.data.example.domain.*;
import jcaga.spring.data.example.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ExamplesService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    private static final String DEFAULT_DEG = "Technical Writer";


    public void manyToOneRelationExample(){
        manyToOneRelationExamplePersistDataToDatabase();
        employeeRepository.findAll().forEach(emp -> log.info(emp.toString()));
    }

    @Transactional// Method must be in one transaction, because it used lazy loading for list books.
    public void oneToManyRelationExample(){
        oneToManyRelationExamplePersistDataToDatabase();
        authorRepository.findAll().forEach(author -> log.info(author.toString()));
    }

    public void oneToOneRelationExample(){
        oneToOneRelationExamplePersistDataToDatabase();
        personRepository.findAll().forEach(person->log.info(person.toString()));
    }

    @Transactional // Method must be in one transaction, because it used lazy loading for list school classes and list teachers.
    public void manyToManyRelationExample() {
        manyToManyRelationExamplePersistDataToDatabase();
        schoolClassRepository.findAll().forEach(schoolClass -> log.info(schoolClass.toString()));
        teacherRepository.findAll().forEach(teacher -> log.info(teacher.toString()));
    }

    @Transactional
    private void manyToOneRelationExamplePersistDataToDatabase(){
        //Create Department Entity
        Department department = new Department();
        department.setName("Development");

        //Store Department
        departmentRepository.save(department);

        //Create Employee1 Entity
        Employee employee1 = new Employee();
        employee1.setName("Satish");
        employee1.setSalary(45000.0);
        employee1.setDeg(DEFAULT_DEG);
        employee1.setDepartment(department);

        //Create Employee2 Entity
        Employee employee2 = new Employee();
        employee2.setName("Krishna");
        employee2.setSalary(45000.0);
        employee2.setDeg(DEFAULT_DEG);
        employee2.setDepartment(department);

        //Create Employee3 Entity
        Employee employee3 = new Employee();
        employee3.setName("Masthanvali");
        employee3.setSalary(50000.0);
        employee3.setDeg(DEFAULT_DEG);
        employee3.setDepartment(department);

        //Store Employees
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }

    @Transactional
    private void oneToManyRelationExamplePersistDataToDatabase() {
        //Create Book1 Entity
        Book book1 = new Book();
        book1.setName("Java");

        //Create Book2 Entity
        Book book2 = new Book();
        book2.setName("Python");

        //Create Book3 Entity
        Book book3 = new Book();
        book3.setName("C++");

        //Store books
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        //Create Books List
        List<Book>  books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        //Create Author Entity
        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Novak");
        author.setBooks(books);

        //Store Author Entity
        authorRepository.save(author);
    }

    @Transactional
    private void oneToOneRelationExamplePersistDataToDatabase(){
        // Create AddressDetail Entity
        AddressDetail addressDetail = new AddressDetail();
        addressDetail.setNumber(10);
        addressDetail.setStreet("Street");
        addressDetail.setZipCode("26601");

        // Persist AddressDetail Entity
        addressRepository.save(addressDetail);

        // Create Person Entity
        Person person = new Person();
        person.setName("Jan");
        person.setSurname("Novak");
        person.setAddressDetail(addressDetail);

        // Persist Person Entity
        personRepository.save(person);
    }

    @Transactional
    private void manyToManyRelationExamplePersistDataToDatabase() {
        //Create Clas Entity
        SchoolClass clas1 = new SchoolClass(null, "1st", null);
        SchoolClass clas2 = new SchoolClass(null, "2nd", null);
        SchoolClass clas3 = new SchoolClass(null, "3rd", null);

        //Store Clas
        schoolClassRepository.save(clas1);
        schoolClassRepository.save(clas2);
        schoolClassRepository.save(clas3);

        //Create SchoolClass Set1
        Set<SchoolClass> classSet1 = new HashSet();
        classSet1.add(clas1);
        classSet1.add(clas2);
        classSet1.add(clas3);

        //Create SchoolClass Set2
        Set<SchoolClass> classSet2 = new HashSet();
        classSet2.add(clas3);
        classSet2.add(clas1);
        classSet2.add(clas2);

        //Create SchoolClass Set3
        Set<SchoolClass> classSet3 = new HashSet();
        classSet3.add(clas2);
        classSet3.add(clas3);
        classSet3.add(clas1);

        //Create Teacher Entity
        Teacher teacher1 = new Teacher(null, "Jan","Java",classSet1);
        Teacher teacher2 = new Teacher(null, "Ondra","Adv Java",classSet2);
        Teacher teacher3 = new Teacher(null, "Honza","DB2",classSet3);

        //Store Teacher
        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);
        teacherRepository.save(teacher3);
    }
}
