# ✈️ Airport Surface Traffic Control Simulation System

This project simulates a simplified **Air Traffic Control System** using Java. It is designed to model and manage the operation of airplanes as they navigate runways, taxiways, and gates within an airport environment.

The system uses **multithreading**, a **global clock**, and a **priority-based task queue** to simulate concurrent actions and scheduling of airplane tasks in real-time.

---

## 📌 Project Description

The core goal of this simulation is to provide a functional model of how airplanes are:

- **Landed** on available runways
- **Moved** through taxiways
- **Parked** or held in position
- **Dispatched** for takeoff when cleared

Each action is managed as a **Task**, and tasks are inserted into a **Task Queue** that dispatches them based on their **priority** and **scheduled execution time**. The system time is managed by a custom `Global_clock` class that simulates real-time passage and synchronization across modules.

---

## 🧩 Core Components

- **Global Clock:** Tracks real-time and synchronizes all operations.
- **Airplane:** Represents an aircraft and its movement through the simulation.
- **Airplane List:** Manages a collection of active airplanes in the simulation.
- **Runway & Taxiway:** Represent airport links with status control (open/closed, occupied).
- **Task & Task Queue:** Define and prioritize actions like landing, parking, and moving.
- **Controll Tasks:** Extended tasks with link transitions and timing.

---

## 🧠 Key Concepts

- **Multithreading:** Global time and task dispatching run on separate threads.
- **Task Scheduling:** Tasks are inserted in order of priority and dispatched at their execution time.
- **State Transitions:** Airplanes move through various operational states (e.g., Approach → Land → Taxi → Park → Takeoff).

---

## 🎯 Objectives

- Simulate basic real-world airport logic using object-oriented programming
- Demonstrate concurrency using Java threads and synchronization
- Create a modular system with extensible components for future expansions (e.g., GUI, networking)

---

## 🛠️ Technologies Used

- Java 8+
- Object-Oriented Design
- Concurrency (Runnable, Threads)
- Collections and Custom Logic

---

## 🧾 Status

This project is in an experimental/prototype phase. It provides a solid foundation for further development, such as visualization, AI-assisted scheduling, or integration with IoT-based sensor systems.

