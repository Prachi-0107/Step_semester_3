# Test Yourself — Solutions & Concept Explanations

Comprehensive solutions to the 8 self-test questions from **Page 13** of the Week 8 Concept Introduction document (`STEP-SEM-3_Week_8_Category_B_ObjectMethods_InnerClasses_UML_Concept_Intro`).

---

### Question 1
**If you never override `toString()`, `equals()`, or `hashCode()`, where do the versions that run when you call them actually come from?**

**Answer:**  
They are inherited directly from `java.lang.Object`. In Java, every class silently extends `Object` as the ultimate root of the class hierarchy if no explicit parent is declared. `Object` provides default implementations for all three methods:
- `toString()` returns `getClass().getName() + "@" + Integer.toHexString(hashCode())`.
- `equals(Object obj)` performs reference identity comparison (`this == obj`).
- `hashCode()` derives an integer hash value based on the object's internal memory address.

---

### Question 2
**`light1 == light2` is false but `light1.equals(light2)` is true for two `SmartLight` objects with the same `deviceId`. Explain why both answers are correct at the same time.**

**Answer:**  
Both expressions test fundamentally different forms of equality:
1. `==` tests **reference identity** — whether two variables refer to the exact same memory location on the heap. Because `light1` and `light2` were instantiated with distinct `new` expressions, they occupy different heap addresses, making `light1 == light2` evaluate to `false`.
2. `.equals()` tests **logical state equivalence**. `SmartLight` overrides `.equals()` to compare the logical `deviceId` strings. Since both objects represent the same physical/logical device (`"LIGHT-01"`), `light1.equals(light2)` evaluates to `true`.

---

### Question 3
**Why must `hashCode()` be overridden whenever `equals()` is overridden, and what specifically breaks if it isn't?**

**Answer:**  
Java enforces the **`equals()`/`hashCode()` Contract**: if two objects are equal according to `equals(Object)`, they must produce the identical integer hash value from `hashCode()`.  
Hash-based collections (`HashSet`, `HashMap`, `Hashtable`) calculate the bucket index using `hashCode()` before calling `equals()` to resolve collision within that bucket. If `equals()` is overridden without `hashCode()`, two logically equal objects retain `Object`'s default memory-address-based hash codes. Consequently, they land in different buckets, and `HashSet` or `HashMap` will fail to recognize them as duplicates, resulting in duplicate entries and lookups returning `null`.

---

### Question 4
**What is the difference between a shallow copy and a deep copy, and which one does `Object`'s `clone()` give you by default?**

**Answer:**  
- **Shallow Copy**: Duplicates the object's top-level fields. Primitive fields are copied by value, but reference fields copy only memory addresses. Thus, both the original and cloned objects share and point to the exact same nested mutable objects (e.g., an internal `ArrayList`). Mutating the list in either copy mutates it for both.
- **Deep Copy**: Duplicates the object and recursively duplicates all nested referenced objects, creating new independent instances. Mutations on one object never leak to the other.
- **Default Behavior**: `Object.clone()` performs a **shallow copy** field-by-field.

---

### Question 5
**`thermostat.new UsageLog()` works, but `new UsageLog()` alone does not. Why does creating a member inner class require an existing outer object?**

**Answer:**  
A non-static member inner class implicitly maintains an invisible reference to an instance of its enclosing outer class (`SmartThermostat.this`). Because its methods (such as `log.record()`) can directly access outer instance fields and methods (`getDeviceId()`), an instance of the inner class cannot exist without an enclosing outer instance to bind to.

---

### Question 6
**What is the one thing a static nested class can never need that a member inner class always has?**

**Answer:**  
An **implicit reference to an enclosing instance of the outer class** (i.e. `OuterClass.this`).  
A static nested class does not hold an outer reference, cannot directly access non-static outer members, and can be instantiated directly using `new OuterClass.StaticNestedClass()` without instantiating the outer class first.

---

### Question 7
**An anonymous inner class implementing `Schedulable` has no name and no separate file. If you needed that same scheduling behavior in three different places in your program, would an anonymous inner class still be the right choice? Why or why not?**

**Answer:**  
**No.**  
Anonymous inner classes are intended for concise, one-off implementations used in a single expression. If the identical scheduling logic is required across three distinct locations, repeating an anonymous inner class duplicates code, violates the DRY (Don't Repeat Yourself) principle, and creates maintenance overhead. Instead, define a named class (either a top-level class, a member inner class, or a static nested class) and instantiate it where needed.

---

### Question 8
**A class diagram and an object diagram can both describe a `SmartLight`, but they look different in one specific way. What does each diagram type answer that the other one cannot?**

**Answer:**  
- **Class Diagram** answers: *"What is the blueprint, type structure, and relationship hierarchy?"* It details inheritance (`extends`), interface realizations (`implements`), field types, and method signatures, but **never contains actual runtime values or object identifiers**.
- **Object Diagram** answers: *"What specific state do concrete instances hold at a frozen moment in time?"* It shows actual runtime values (e.g., `deviceId = "LIGHT-01"`, `powerOn = true`) for specific instances identified by underlined headings (`<u>light1 : SmartLight</u>`), which a class diagram cannot express.
