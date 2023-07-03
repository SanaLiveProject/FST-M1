# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
    'FirstName': ["Sana", "Sara", "Zara"],
    'LastName': ["Afreen", "chotu", "motu"],
    'Email': ["safreen@example.com", "sara@example.com", "zara@example.com"],
    'PhoneNumber': ["4537829158", "4892184058", "4528727830"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index=False)

# Commit data to the Excel file
writer._save()
