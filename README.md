# springboot-demoapi
springboot-demoapi

* https://terasolunaorg.github.io/guideline/public_review/ArchitectureInDetail/Validation.html

* buildConstraintViolationWithTemplate（）
```
 ...
 @Override
public boolean isValid(final String label,
                       final ConstraintValidatorContext constraintValidatorContext) {
     constraintValidatorContext.disableDefaultConstraintViolation();

     if(label.length() > MAX_LENGTH) {
          constraintValidatorContext
                  .buildConstraintViolationWithTemplate("{error.maxLength}")
                  .addConstraintViolation();
          return false;
     }
     ...
}
```

* customize check annotation
  * NotBlank p1
```
com.example.demo.api.comm.validation.NotBlank.java
ValidationMessages.properties
com.example.demo.api.comm.validation.NotBlank.message={item} is Not Blank
```
  * NotBlank p2
  ```
  com.example.demo.api.comm.validation.NotBlank.message={param} is Not Blank
  ```
