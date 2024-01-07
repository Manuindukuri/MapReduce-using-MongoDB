input_file = 'movies.dat'
output_file = 'movies_out.csv'

# Read the input file
with open(input_file, 'r') as file:
    content = file.read()

# Replace '::' with ','
modified_content = content.replace('::', ',')

# Save the modified content to the output file
with open(output_file, 'w') as file:
    file.write(modified_content)

print("Replacement complete. Modified content saved to", output_file)
