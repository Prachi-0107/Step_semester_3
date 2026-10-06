# Step_semester_3

Repository for STEP Semester 3 Object-Oriented Programming (Java) coursework, structured in accordance with the official **STEP GitHub Repository Structure Guide**.

---

## Repository Architecture & Branching Standard

- **`main`**: Documentation only — contains the running daily session logs in `README.md`.
- **`develop`**: Clean base project skeleton with empty package structure (`src/main/java/.gitkeep`). Feature branches are never merged back into `develop`.
- **`feature/session_n`**: Dedicated branch per session created from `develop`. Each contains topic-level packages with `class_problems` and `assigment_problems`.

### Session to Branch Mapping

| Session | Week | Topic Package | Branch Name | Key Concepts |
| :--- | :--- | :--- | :--- | :--- |
| **Session 1** | Week 3 | `classes_and_objects` | `feature/session_1` | Classes, Objects, Parallel Arrays to OOP, Encapsulation, Reference vs Content Equality, Static Members |
| **Session 2** | Week 4 | `constructors_and_keywords` | `feature/session_2` | Default vs Parameterized Constructors, Overloading, `this()` Chaining, `this` Keyword, `final`, Static Blocks, `instanceof` |
| **Session 3** | Week 7 | `abstraction_and_interface` | `feature/session_3` / `feature/session_7` | Abstract Classes, Abstract Methods, Interfaces, Polymorphism, Multi-level Inheritance, Method Overriding |
| **Session 4** | Week 8 | `object_methods_and_inner_classes` | `feature/session_4` / `feature/session_8` | `Object` methods (`toString`, `equals`, `hashCode`), `clone()`, Shallow vs Deep Copy, Inner Classes (Member, Static Nested, Local, Anonymous), UML Models |

---

## Daily Session Logs

## Date: 07-10-2026

**Today's Work:**
- Completed and verified full assignment implementation for **Week 8: Object Class Methods, Inner Classes & UML Diagrams** (`STEP-SEM-3_Week_8_Category_B_ObjectMethods_InnerClasses_UML_Concept_Intro`) across `feature/session_4` and `feature/session_8`:
  - **`class_problems` Refinements & Validations**:
    - `ObjectMethodsDemo.java`: Aligned with Sections 1–3. `Device` abstract base class provides overridden `toString()`; `SmartLight` inherits `toString()`, overrides `equals(Object)` with safe `instanceof` check, and implements consistent `hashCode()`. Verified `==` vs `.equals()` and `HashSet` deduplication.
    - `CloningDemo.java`: Aligned with Section 4. Implemented `ScheduleConfig` demonstrating `Cloneable`, shallow copy reference sharing leak (`[07:00, 22:00]`) vs genuine deep copy list isolation (`[07:00]`), along with composite `SmartDoorLock` deep cloning.
    - `InnerClassesDemo.java`: Aligned with Section 5. Demonstrated Member Inner Class (`SmartThermostat.UsageLog` accessing enclosing instance state), Static Nested Class (`SmartThermostat.TemperatureReading`), Local Inner Class (`calibrate()` method with `CalibrationOffset`), and Anonymous Inner Class (`Schedulable weekendOnly`).
    - `AnonymousInnerClassDemo.java`: Demonstrated standalone and parameter-passed anonymous inner classes implementing `Schedulable` and `DeviceAction`.
    - `SmartHomeIntegrationDemo.java`: Executed the complete Section Wrap-Up ("The Whole Smart Home, Part 2 — In One Program" from Page 11) with byte-exact matching output.
  - **`assigment_problems`**:
    - `DeviceEqualityAudit.java`: Audited all 5 equality contract axioms (reflexive, symmetric, transitive, consistent, non-nullity) alongside hash bucketing in `HashSet` and `HashMap`.
    - `DeepCopyDeviceProfile.java`: Multi-level deep cloning of device security profiles ensuring complete isolation.
    - `SmartSensorLogManager.java`: Member inner class telemetry entries with outer instance binding and static nested data records.
    - `AnonymousCallbackDemo.java`: Event dispatcher supporting specialized anonymous inner class listeners for security alerts, power logging, and emergency dispatch.
    - `SmartHomeUMLModelDemo.java`: Directly modeled Section 6 UML Class inheritance, Object runtime snapshots, and Sequence diagram `connectAllToApp` flow.
  - **Comprehensive Documentation & Solutions**:
    - `UML_DIAGRAMS_AND_CONCEPTS.md`: Added complete Mermaid diagrams for UML Class Diagram, Object Diagram, and Sequence Diagram, including notation rules and diagram comparison matrix.
    - `TEST_YOURSELF_SOLUTIONS.md`: Documented complete, technical answers to all 8 self-test questions from Page 13 of the concept guide.
- Compiled all Java files with `javac 25` and verified zero compilation errors and exact console outputs.
- Pushed updated feature branches `feature/session_4` and `feature/session_8` to GitHub.

**Next Session Plan:**
- Review all completed Semester 3 modules (Sessions 1-4 / Weeks 3, 4, 7, 8) in preparation for upcoming lab assessments and evaluations.

**Issues Faced:**
- None.

---

## Date: 03-10-2026

**Today's Work:**
- Implemented **Week 8: Object Class Methods, Inner Classes & UML Concepts** under package `object_methods_and_inner_classes` on branch `feature/session_4` (and `feature/session_8`):
  - **`class_problems`**:
    - `ObjectMethodsDemo.java`: Overriding `toString()`, `equals()`, and `hashCode()` contract verification, demonstrating `==` vs `.equals()` and `HashSet` deduplication.
    - `CloningDemo.java`: `Cloneable` interface, `super.clone()`, shallow copy reference sharing vs deep copy isolation with `ScheduleConfig` and `SmartDoorLock`.
    - `InnerClassesDemo.java`: Member inner class (`SmartThermostat.UsageLog` accessing enclosing private state), static nested class (`TemperatureReading`), and local inner class (`CalibrationOffset`).
    - `AnonymousInnerClassDemo.java`: On-the-fly anonymous inner class implementations of `Schedulable` callback interface.
    - `SmartHomeIntegrationDemo.java`: Complete unified Smart Home Part 2 program combining all core concepts.
  - **`assigment_problems`**:
    - `DeviceEqualityAudit.java`: Complete audit of all 5 equality contract axioms (reflexive, symmetric, transitive, consistent, non-null) with collection hashing.
    - `DeepCopyDeviceProfile.java`: Multi-level deep cloning of device security profiles ensuring zero mutation leaks.
    - `SmartSensorLogManager.java`: Member inner class telemetry entries with outer instance binding.
    - `AnonymousCallbackDemo.java`: Event dispatcher supporting multiple specialized anonymous inner class listeners.
    - `SmartHomeUMLModelDemo.java`: Executable Java implementation modeling UML Class, Object, and Sequence relationships.
- All files compiled and verified with zero errors.

**Next Session Plan:**
- Prepare for upcoming Semester 3 lab evaluations and review assessments.

**Issues Faced:**
- None.

---

## Date: 03-10-2026

**Today's Work:**
- Implemented **Week 7: Abstraction & Interface** under package `abstraction_and_interface` on branch `feature/session_3` (and `feature/session_7`):
  - **`class_problems`**:
    - `TalkingToyBoxDemo.java`: Abstract class `Toy` with static ID counter (`TOY-1001`, `TOY-1002`), abstract `makeSound()`, concrete `ToyCar` and `ToyRobot` subclasses.
    - `WarehouseLabelPrinterDemo.java`: `Printable` interface implemented by unrelated classes `PackageBox` and `Invoice`, with polymorphic `printAll()` routine.
    - `OrchestraWarmUpDemo.java`: 3-level inheritance hierarchy (`Instrument` -> `StringInstrument` -> `Violin`), overriding `play()` while calling `super.play()`.
  - **`assigment_problems`**:
    - `SmartKitchenAssistantDemo.java`: Abstract `KitchenTool` with JavaBean speed level validation (1-5), `Washable` interface, and `Blender` concrete class.
    - `PackageDropOffLogDemo.java`: Abstract `DeliveryNote`, overloaded compile-time polymorphic `confirmDelivery(String signature)` chaining internally, `ParcelNote` and `LetterNote` subclasses, and `logAll()` polymorphic dispatch.
    - `AbstractionInterfacePracticeDemo.java`: Comprehensive automated test harness running and validating all 5 scenarios.
- All files compiled and executed against reference specifications.

**Next Session Plan:**
- Proceed to Week 8 Object Methods, Inner Classes, and UML Diagram modeling.

**Issues Faced:**
- None.

---

## Date: 03-10-2026

**Today's Work:**
- Implemented **Week 4: Constructors and Java Keywords** under package `constructors_and_keywords` on branch `feature/session_2`:
  - **`class_problems`**:
    - `DefaultConstructorDemo.java`: Default (free) constructor vs explicit parameterized constructor, field default initialization.
    - `OverloadingDemo.java`: Constructor overloading with `this(...)` delegation chaining for theory and lab courses.
    - `ThisKeywordDemo.java`: Resolving parameter/field name shadowing and passing instance references.
    - `FinalDemo.java`: Final variables, final calculation methods locked against overriding, and final immutable classes.
    - `StaticBlockDemo.java`: One-time static initialization block execution upon class loading.
    - `InstanceofDemo.java`: Type checking with `instanceof` and safe polymorphic downcasting between `FeeAccount` and `HostelFeeAccount`.
  - **`assigment_problems`**:
    - `LibraryBookCatalogDemo.java` (M1): Two constructors chained via `this()`, missing ISBN defaulting to "PENDING", batch cataloguing.
    - `PayrollBonusDemo.java` (M2): `Employee` with `raiseSalary(double salary)` resolving naming collision with `this`, batch festival bonus raise.
    - `LateFeeCalculationDemo.java` (M3): `final double calculateLateFee(int daysLate)`, `final void printSummary(int daysLate)`, skipping daysLate <= 0.
    - `CollegeSetupBatchDemo.java` (M4): One-time setup with `static { ... }` block for college info, batch student creation.
    - `AccountBatchPaymentDemo.java` (M5): `instanceof` payment dispatch and account type counter tracking.
- All programs compiled and tested with exact matching outputs.

**Next Session Plan:**
- Proceed to Week 7 Abstraction & Interface practice problems.

**Issues Faced:**
- None.

---

## Date: 03-10-2026

**Today's Work:**
- Implemented **Week 3: Classes and Objects** under package `classes_and_objects` on branch `feature/session_1`:
  - **`class_problems`**:
    - `PlacementRecordDemo.java` (M1): Migrated parallel arrays (names, companies, packages) into a clean `PlacementRecord` class and array of objects.
    - `MessWalletDemo.java` (M2): Encapsulated hostel mess-card wallet with controlled `topUp()`, `deduct()`, and read-only `getBalance()`.
    - `CourseDemo.java` (M3): Constructor overloading with `this()` chaining for theory-only and lab-integrated courses.
    - `IdCardDemo.java` (M4): Reference copies vs distinct objects, evaluating identity (`==`) and mutation side-effects.
    - `StudentDemo.java` (M5): Instance variables vs static class-level state (`collegeName`, `studentCount`).
  - **`assigment_problems`**:
    - `StudentPlacementTracker.java`: Batch placement aggregation, filtering by threshold, and top package lookup.
    - `DigitalWallet.java`: Encapsulated student wallet with daily expenditure quotas and audit tracking.
    - `CourseRegistration.java`: Constructor chaining for lecture, lab, and capstone project credits.
    - `LibraryMembershipCard.java`: Membership card tracking, checkout quota verification, and aliasing analysis.
    - `UniversityDepartment.java`: University department registry leveraging static counters and reports.
- All code compiled cleanly with `javac` and verified.

**Next Session Plan:**
- Proceed to Week 4 Constructors and Java Keywords session work.

**Issues Faced:**
- None.