# virtual-thread-benchmark-project

Virtual Thread Testing Benchmark Project

## How to Run

Create the .env file or you can copy from the .env.sample
and match the user and password for database you want to use

Modify the `db_migration/init_all.sql` file to match
the user and password you use

Use this command to build up your container and run it

```
docker-compose up
```

If there any issues, and you need the java image to be re-build
then you can use this command

```
docker-compose up --build
```

## How to Load Test

You can go to [this repository](https://github.com/frannajaya/load-test-scripts.git) to clone the k6
script
