<h1 align="center">
  <br>
  <img src="./parcel-delivery.png" alt="Parcel Delivery" width="200"></a>
</h1>

## How To Use

```bash
# Clone this repository
$ git clone https://github.com/shubo/parcel-delivery.git
# Pull Postgres Docker Image
$ docker pull postgres
# Run Postgres Containers
$ docker run --name user-ms-db -p 5432:5432 -e POSTGRES_PASSWORD=mypass -e POSTGRES_DB=user_db -d postgres
$ docker run --name order-ms-db -p 5433:5432 -e POSTGRES_PASSWORD=mypass -e POSTGRES_DB=order_db -d postgres
```