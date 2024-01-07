@echo off

set MONGO_PATH=D:\mongotools\bin
set DB_NAME=NYSE
set COLLECTION_NAME=stocks
set CSV_FOLDER=D:\stocks

for %%f in (%CSV_FOLDER%\*.csv) do (
    Echo Importing file: %%f
    %MONGO_PATH%\mongoimport --db=NYSE --collection=stocks --type=csv --headerline --file="%%f"
)

echo Import completed!
