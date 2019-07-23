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
